package com.antutu.benchmark.activity;

import android.content.SearchRecentSuggestionsProvider;

public class SearchSuggestionProvider extends SearchRecentSuggestionsProvider {
    public SearchSuggestionProvider() {
        setupSuggestions("com.antutu.benchmark.activity.SearchSuggestionProvider", 1);
    }
}
