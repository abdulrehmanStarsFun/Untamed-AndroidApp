package com.example.uhunt.jetpackClassess

import com.example.uhunt.R
import com.example.uhunt.jetpackClassess.model.HomeScreenItems
import com.example.uhunt.jetpackClassess.model.Item
import com.example.uhunt.jetpackClassess.model.Tweet

object DemoDataProvider {

    val itemList = listOf(
        Item(
            1,
            "Fresh Vegges and Greens",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food1
        ),
        Item(
            2,
            "Best blue berries",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food2
        ),
        Item(
            3,
            "Cherries La Bloom",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food3
        ),
        Item(
            4,
            "Fruits everyday",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food4
        ),
        Item(
            5,
            "Sweet and sour",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food5
        ),
        Item(
            6,
            "Pancakes for everyone",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food6
        ),
        Item(
            7,
            "Cupcakes and sparkle",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food7
        ),
        Item(
            8,
            "Best Burgers shop",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food8
        ),
        Item(
            9,
            "Coffee of India",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food9
        ),
        Item(
            10,
            "Pizza boy town",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food10
        ),
        Item(
            11,
            "Burgers and Chips",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food11
        ),
        Item(
            12,
            "Breads and butter",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food12
        ),
        Item(
            13,
            "Cupcake factory",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food13
        ),
        Item(
            14,
            "Breakfast paradise",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food14
        ),
        Item(
            15,
            "Cake and Bake",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food15
        ),
        Item(
            16,
            "Brunch and Stakes",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food16
        )
    )

    val item = Item(
        1,
        "Awesome List Item",
        "Very awesome list item has very awesome subtitle. This is bit long",
        R.drawable.food6
    )

    val tweet = Tweet(
        1,
        "Jetpack compose is the next thing for andorid. Declarative UI is the way to go for all screens.",
        "The Verge",
        "@verge",
        "12m",
        R.drawable.food1,
        100,
        12,
        15,
        "Twitter for web"
    )

    val tweetList = listOf(
        tweet,
        tweet.copy(
            id = 2,
            author = "All",
            handle = "@google",
            tweetImageId = R.drawable.food16,
            time = "11m"
        ),
        tweet.copy(
            id = 3,
            author = "Following",
            handle = "@Amazon",
            tweetImageId = R.drawable.food16,

            time = "1h"
        ),
        tweet.copy(
            id = 4,
            author = "Channels",
            handle = "@Facebook",
            tweetImageId = R.drawable.food16,

            time = "1h"
        ),
        tweet.copy(
            id = 5,
            author = "Series",
            handle = "@Instagram",
            tweetImageId = R.drawable.food15,
            time = "11m"
        ),
        tweet.copy(
            id = 6,
            author = "Categories",
            handle = "@Twitter",
            tweetImageId = R.drawable.food3,
            time = "11m"
        ),


    )

   val tweetListwithNoImage = listOf(
        tweet,
        tweet.copy(
            id = 2,
            author = "Google",
            handle = "@google",
            time = "11m"
        ),
        tweet.copy(
            id = 3,
            author = "Amazon",
            handle = "@Amazon",
            time = "1h"
        ),
        tweet.copy(
            id = 4,
            author = "Facebook",
            handle = "@Facebook",

            time = "1h"
        ),
        tweet.copy(
            id = 5,
            author = "Instagram",
            handle = "@Instagram",

            time = "11m"
        ),
        tweet.copy(
            id = 6,
            author = "Twitter",
            handle = "@Twitter",

            time = "11m"
        ),
        tweet.copy(
            id = 7,
            author = "Netflix",
            handle = "@Netflix",

            time = "11m"
        ),
        tweet.copy(
            id = 8,
            author = "Tesla",
            handle = "@Tesla",

            time = "1h"
        ),
        tweet.copy(
            id = 9,
            author = "Microsoft",
            handle = "@Microsoft",

            time = "1h"
        ),
        tweet.copy(
            id = 3,
            author = "Tencent",
            handle = "@Tencent",

            time = "1h"
        ),
        tweet.copy(
            id = 4,
            author = "Snapchat",
            handle = "@Snapchat",

            time = "1h"
        ),


    )

    val homeScreenListItems = listOf(
        HomeScreenItems.ListView("Vertical"),
        HomeScreenItems.ListView("Horizontal"),
        HomeScreenItems.ListView("Grid"),
        HomeScreenItems.Modifiers,
        HomeScreenItems.Layouts,
        HomeScreenItems.ConstraintsLayout,
        HomeScreenItems.MotionLayout,
        HomeScreenItems.AdvanceLists,
        HomeScreenItems.CustomFling,
        HomeScreenItems.AndroidViews,
        HomeScreenItems.Carousel,
        HomeScreenItems.Dialogs,
        HomeScreenItems.TabLayout,
        HomeScreenItems.BottomSheets,
        HomeScreenItems.PullRefresh,
    )

    const val longText =
        "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae"

    val demoUiList = listOf(
        "Instagram",
        "Twitter",
        "Gmail",
        "Youtube",
        "Spotify",
        "CryptoApp+MVVM",
        "MoviesApp+MVVM",
        "DatingApp",
        "TikTok",
        "Paint",
        "Meditation"
    )

}