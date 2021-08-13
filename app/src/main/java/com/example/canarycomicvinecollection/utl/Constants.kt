package com.example.canarycomicvinecollection.utl

class Constants{
    companion object{
        const val COMIC_VINE_BASE_URL = "https://comicvine.gamespot.com/"
        const val COMIC_VINE_API_KEY = "api_key"
        const val COMIC_VINE_API_FORMAT = "format"
        const val COMIC_VINE_API_FILTER = "filter"
        const val COMIC_VINE_API_SORT = "sort"
        const val COMIC_VINE_API_OFFSET = "offset"
        const val COMIC_VINE_API_LIMIT = "limit"

        const val API_KEY_HEADER = "api_key=$COMIC_VINE_API_KEY"
        const val API_FORMAT_HEADER = "format=$COMIC_VINE_API_FORMAT"
        const val API_FILTER = "format=$COMIC_VINE_API_FILTER"
        const val API_SORT = "sort=$COMIC_VINE_API_SORT"
        const val API_OFFSET = "offset=$COMIC_VINE_API_OFFSET"
        const val API_LIMIT = "limit=$COMIC_VINE_API_LIMIT"

        const val PATH = "$API_KEY_HEADER&$API_FORMAT_HEADER&$API_FILTER&$API_SORT&$API_OFFSET&$API_LIMIT"
        const val VOLUMES_END_POINT = "api/volumes?$PATH"
        const val ISSUES_END_POINT = "api/issues?$PATH"
        const val ISSUE_END_POINT = "api/issue?$PATH"
        const val VOLUME_END_POINT = "api/volume?$PATH"

        const val SEARCH_QUERY = "filter"
    }
}