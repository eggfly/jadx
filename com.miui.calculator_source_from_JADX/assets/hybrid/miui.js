(function (root, factory) {
    if (typeof define === 'function' && (define.amd||define.cmd)) {
        define(function(){
            return factory(root);
        });
    } else if (typeof exports === 'object') {
        module.exports = factory(root);
    } else {
        root.miui = root.mi = factory(root);
    }
}(this, function (global) {

    var cfg = null;
    var callback_count = 1;
    var MiuiJsBridge = global['MiuiJsBridge']||{};

    /**
     * MIUI SDK features
     */
    var feature_list_maps = {
    "share":{
        "feature":"miui.hybrid.feature.Share",
        "action":"send"
    },
    "getDeviceInfo":{
        "feature":"miui.hybrid.feature.Device",
        "action":"getDeviceInfo"
    },
    "getLocation":{
        "feature":"miui.hybrid.feature.Geolocation",
        "action":"get"
    },
    "subscribeLocation":{
        "feature":"miui.hybrid.feature.Geolocation",
        "action":"enableListener"
    },
    "unsubscribeLocation":{
        "feature":"miui.hybrid.feature.Geolocation",
        "action":"disableListener"
    },
    "getNetworkType":{
        "feature":"miui.hybrid.feature.Network",
        "action":"getType"
    },
    "subscribeNetwork":{
        "feature":"miui.hybrid.feature.Network",
        "action":"enableNotification"
    },
    "unsubscribeNetwork":{
        "feature":"miui.hybrid.feature.Network",
        "action":"disableNotification"
    },
    "scanBarcode":{
        "feature":"miui.hybrid.feature.Barcode",
        "action":"scan"
    }
}
;

    /**
     * Third party features
     */
    var third_feature_map = {
}
;

    mixin(feature_list_maps,(third_feature_map||{}));

    /**
     * @param options
     */
    function mapFeature(options) {
        var features = options.features;
        var item,fea;
        for (var i in features) {
            item = features[i];
            fea = feature_list_maps[item.name]||{};
            if(fea['feature']){
                item['name'] = fea['feature'];
            }
        }
        options.features = uniqueObject(options.features);
        return options;
    }

    function uniqueObject(arr){
        var cache = {},ret = [],j = '',item = null;

        for (var i=0,len = arr.length;i<len;i++){
            item  = arr[i];
            j = JSON.stringify(item);
            if (!cache[j]){
                ret.push(item);
                cache[j] = 1
          }
        }
        return ret;
    }

    /**
     * 日志跟踪
     * @param message
     */
    function trace(message) {
        window.console && console.log(message);
    }

    /**
     * 判断是否是函数
     * @param o
     * @returns {boolean}
     */
    function isFunction(o) {
        return o && ({}.toString.call(o) === '[object Function]');
    }

    /**
     * 判断是否是对象
     * @param o
     * @returns {boolean}
     */
    function isObject(o) {
        return o && (o.constructor === Object || {}.toString.call(o) === "[object Object]");
    }

    /**
     * 包装一个对外的函数，供客户端调用
     * @param options
     * @returns {string}
     */
    var buildCallback = function (options) {
        var guid = (callback_count++).toString();
        var callbackName = options.callback|| ('MiuiJsBridge_Callbacks_' + guid);

        window[callbackName] = function () {
            if (cfg && cfg.debug) {
                alert.apply(this, arguments);
                return;
            }
            var success = options.success,
                fail = options.fail,
                cancel = options.cancel,
                complete = options.complete;

            var params = [].slice.call(arguments);
            var code = JSON.parse(params[0]).code;

            if (code >= 0 && code < 99) {
                success && isFunction(success) && success.apply(this, arguments);
            } else if (code >= 100 && code < 199) {
                cancel && isFunction(cancel) && cancel.apply(this, arguments);
            } else {
                fail && isFunction(fail) && fail.apply(this, arguments);
            }

            complete && isFunction(complete) && complete.apply(this, arguments);

            if(!options.callback){
                window[callbackName] = null ;
                delete window[callbackName];
            }

        };

        return callbackName;
    }

    function mixin(des, src) {
        for (var n in src) {
            if(src.hasOwnProperty(n)){
                des[n] = src[n];
            }
        }
        return des;
    }

    function getSignParams(options){
        cfg = options;
        return  mapFeature(options);
    }

    var exports = {
        version: '0.0.1',
        mixin:mixin,
        isSupported:(function(){
            return !!MiuiJsBridge.invoke;
        }()),
        getSignParams:getSignParams,
        config: function (options) {
            options = getSignParams(options);
            if (MiuiJsBridge.config) {
                return MiuiJsBridge.config(JSON.stringify(options));
            }else{
                trace('webview has no config method!');
            }
        }
    }

    function add(feature_maps){

        var _exports = {};

        for (var key in feature_maps) {

            (function (key) {

                _exports[key] = function (options) {
                    options = options || {};
                    var item = feature_maps[key];
                    var func = options.success || options.fail || options.cancel || options.complete || null;
                    if (MiuiJsBridge.invoke) {
                        if(isFunction(func)){
                            func = buildCallback(options);
                            MiuiJsBridge.invoke(item.feature,item.action,JSON.stringify(options), func);
                        }else{
                            return  MiuiJsBridge.invoke(item.feature,item.action,JSON.stringify(options), func);
                        }
                    } else {
                        trace('webview has no invoke method!');
                    }
                }
            }(key))
        }

        mixin(exports,_exports);

    }

    add(feature_list_maps);

    return exports;

}));