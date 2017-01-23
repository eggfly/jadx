function setViewport(canvas_width, screen_width) {
    try {
        var scale = 1.0;
        if (canvas_width > 0)
            scale = screen_width / canvas_width *19/20;
        var viewport = document.getElementById("viewport");
        viewport.content = "width=device-width,initial-scale=" + scale.toFixed(1) + ",minimum-scale=0.1,maximum-scale=2.0,user-scalable=yes";
        // console.log(viewport.content);
    } catch (err) {
    }
}
