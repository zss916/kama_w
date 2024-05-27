package com.kama.kama.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.kama.kama.R
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class HomeData(
    val icon: Int,
    val title: String,
    val price: String,
    val introduce: String,
    val seen: Int,
    val liked: Int,
): Parcelable


@Parcelize
data class HomeTab(
    val icon: Int,
    val iconSelect: Int,
    val title: String,
): Parcelable


val homeList = listOf(

    //沙发
    HomeData(
        icon = R.drawable.sofa1,
        title = "LANDSKRONA",
        price = "$13999",
        seen = 100,
        liked = 123,
        introduce = "Bring you luxury. We use high elastic sponge filler to ensure comfort, the contact surface is a first layer of cowhide to ensure beauty, and the rest of the use of wear-resistant artificial leather to reduce costs."),

    HomeData(
        icon = R.drawable.sofa2,
        title = "VISKAFORS",
        price = "$8999",
        seen = 98,
        liked = 103,
        introduce = "A sofa can add a personal touch to a room. Its design is classic, and its shape is spacious and comfortable - when you sit in the deep soft seats, you can enjoy the feeling of being hugged."),

    HomeData(
        icon = R.drawable.sofa3,
        title = "GRÖNLID",
        price = "$8699",
        seen = 34,
        liked = 66,
        introduce = "Provide modules that can be combined at will to help you create a custom sofa for yourself and your family. The collection offers a sofa bed that can be easily transformed into a bed with a thick, comfortable mattress"),

    HomeData(
        icon = R.drawable.sofa4,
        title = "VIMLE",
        price = "$8399",
        seen = 78,
        liked = 201,
        introduce = "This frame cover has light resistance level 5, durable fabric, wool-like texture, warm and soft appearance, and presents a two-color blend."),

    //柜子
    HomeData(
        icon = R.drawable.cabinet1,
        title = "HEMNES",
        price = "$3499",
        seen = 89,
        liked = 90,
        introduce = "The material is solid pine from sustainable sources, a natural, renewable material that will make furniture more attractive over time. Like it? It can be used with other products in the HEMNES range"),

    HomeData(
        icon = R.drawable.cabinet2,
        title = "BILLY",
        price = "$1897",
        seen = 289,
        liked = 90,
        introduce = "With flexible functions, it can be used for multiple purposes in the home. With panel/glass doors to display items and keep them neat, suitable for use in both living and dining areas."),

    HomeData(
        icon = R.drawable.cabinet3,
        title = "EKET",
        price = "$1860",
        seen = 191,
        liked = 92,
        introduce = "You can create a classic storage solution with just a few lockers, or you can use as many as you want, combining them in unexpected and interesting ways to make the space more personal while meeting your needs"),

    HomeData(
        icon = R.drawable.cabinet4,
        title = "KALLAX",
        price = "$1139",
        seen = 433,
        liked = 222,
        introduce = "Whether set up or laid out, the KALLAX series is designed to suit your taste, space, budget and usage needs. It can also be matched with drawers, shelves, storage boxes and plug-ins."),

    //餐具

    HomeData(
        icon = R.drawable.tableware1,
        title = "GLADELIG",
        price = "$79.9",
        seen = 632,
        liked = 12,
        introduce = "Simple and elegant shape and bright craft appearance, excellent embellishment table. Unique design, highlight the classic style."),

    HomeData(
        icon = R.drawable.tableware2,
        title = "KEJSERLIG",
        price = "$29.99",
        seen = 1200,
        liked = 32,
        introduce = "Treat yourself and your guests to a normal workday. Add a touch of style and color to your table setting and enjoy the warm and cozy atmosphere."),

    HomeData(
        icon = R.drawable.tableware3,
        title = "SILVERSIDA",
        price = "$39.99",
        seen = 200,
        liked = 47,
        introduce = "Tableware is suitable for grand formal dinner occasions, but also suitable for casual snacks night. You can use the whole collection, or you can choose part of it as a beautiful finishing touch to create a light or bright table setting"),

    HomeData(
        icon = R.drawable.tableware4,
        title = "STRIMMIG",
        price = "$59.99",
        seen = 99,
        liked = 38,
        introduce = "Simple modern details combined with handmade textures create many possibilities for you."),

    //椅子

    HomeData(
        icon = R.drawable.chair1,
        title = "LOBERGET",
        price = "$199",
        seen = 592,
        liked = 129,
        introduce = "Height adjustable, comfortable and practical. Pressure sensing casters. Don't worry. Round design, easy to clean"),

    HomeData(
        icon = R.drawable.chair2,
        title = "SOTENÄS",
        price = "$999",
        seen = 2012,
        liked = 780,
        introduce = "Create comfortable seating and spacious seating. Steel legs, tubular frame design. Stable and safe, easy to carry."),

    HomeData(
        icon = R.drawable.chair3,
        title = "OSKARSHAMN",
        price = "$1499",
        seen = 230,
        liked = 200,
        introduce = "Classic wing chair design, can provide strong support, breathable moisture absorption, comfortable sitting."),

    HomeData(
        icon = R.drawable.chair4,
        title = "VEDBO",
        price = "$1299",
        seen = 1223,
        liked = 20,
        introduce = "Soft, sharp lines create an elegant silhouette. Placed in an open environment, you can have your own small world, without affecting the interaction with friends. Brown pink cushioning adds warmth and vitality."),
    )

val chairList = listOf(

    //椅子

    HomeData(
        icon = R.drawable.chair1,
        title = "LOBERGET",
        price = "$199",
        seen = 592,
        liked = 129,
        introduce = "Height adjustable, comfortable and practical. Pressure sensing casters. Don't worry. Round design, easy to clean"),

    HomeData(
        icon = R.drawable.chair2,
        title = "SOTENÄS",
        price = "$999",
        seen = 2012,
        liked = 780,
        introduce = "Create comfortable seating and spacious seating. Steel legs, tubular frame design. Stable and safe, easy to carry."),

    HomeData(
        icon = R.drawable.chair3,
        title = "OSKARSHAMN",
        price = "$1499",
        seen = 230,
        liked = 200,
        introduce = "Classic wing chair design, can provide strong support, breathable moisture absorption, comfortable sitting."),

    HomeData(
        icon = R.drawable.chair4,
        title = "VEDBO",
        price = "$1299",
        seen = 1223,
        liked = 20,
        introduce = "Soft, sharp lines create an elegant silhouette. Placed in an open environment, you can have your own small world, without affecting the interaction with friends. Brown pink cushioning adds warmth and vitality."),
)

val sofaList = listOf(

    //沙发
    HomeData(
        icon = R.drawable.sofa1,
        title = "LANDSKRONA",
        price = "$13999",
        seen = 100,
        liked = 123,
        introduce = "Bring you luxury. We use high elastic sponge filler to ensure comfort, the contact surface is a first layer of cowhide to ensure beauty, and the rest of the use of wear-resistant artificial leather to reduce costs."),

    HomeData(
        icon = R.drawable.sofa2,
        title = "VISKAFORS",
        price = "$8999",
        seen = 98,
        liked = 103,
        introduce = "A sofa can add a personal touch to a room. Its design is classic, and its shape is spacious and comfortable - when you sit in the deep soft seats, you can enjoy the feeling of being hugged."),

    HomeData(
        icon = R.drawable.sofa3,
        title = "GRÖNLID",
        price = "$8699",
        seen = 34,
        liked = 66,
        introduce = "Provide modules that can be combined at will to help you create a custom sofa for yourself and your family. The collection offers a sofa bed that can be easily transformed into a bed with a thick, comfortable mattress"),

    HomeData(
        icon = R.drawable.sofa4,
        title = "VIMLE",
        price = "$8399",
        seen = 78,
        liked = 201,
        introduce = "This frame cover has light resistance level 5, durable fabric, wool-like texture, warm and soft appearance, and presents a two-color blend."),

)

val cabinetList = listOf(

    //柜子
    HomeData(
        icon = R.drawable.cabinet1,
        title = "HEMNES",
        price = "$3499",
        seen = 89,
        liked = 90,
        introduce = "The material is solid pine from sustainable sources, a natural, renewable material that will make furniture more attractive over time. Like it? It can be used with other products in the HEMNES range"),

    HomeData(
        icon = R.drawable.cabinet2,
        title = "BILLY",
        price = "$1897",
        seen = 289,
        liked = 90,
        introduce = "With flexible functions, it can be used for multiple purposes in the home. With panel/glass doors to display items and keep them neat, suitable for use in both living and dining areas."),

    HomeData(
        icon = R.drawable.cabinet3,
        title = "EKET",
        price = "$1860",
        seen = 191,
        liked = 92,
        introduce = "You can create a classic storage solution with just a few lockers, or you can use as many as you want, combining them in unexpected and interesting ways to make the space more personal while meeting your needs"),

    HomeData(
        icon = R.drawable.cabinet4,
        title = "KALLAX",
        price = "$1139",
        seen = 433,
        liked = 222,
        introduce = "Whether set up or laid out, the KALLAX series is designed to suit your taste, space, budget and usage needs. It can also be matched with drawers, shelves, storage boxes and plug-ins."),
)

val tablewareList = listOf(

    //餐具

    HomeData(
        icon = R.drawable.tableware1,
        title = "GLADELIG",
        price = "$79.9",
        seen = 632,
        liked = 12,
        introduce = "Simple and elegant shape and bright craft appearance, excellent embellishment table. Unique design, highlight the classic style."),

    HomeData(
        icon = R.drawable.tableware2,
        title = "KEJSERLIG",
        price = "$29.99",
        seen = 1200,
        liked = 32,
        introduce = "Treat yourself and your guests to a normal workday. Add a touch of style and color to your table setting and enjoy the warm and cozy atmosphere."),

    HomeData(
        icon = R.drawable.tableware3,
        title = "SILVERSIDA",
        price = "$39.99",
        seen = 200,
        liked = 47,
        introduce = "Tableware is suitable for grand formal dinner occasions, but also suitable for casual snacks night. You can use the whole collection, or you can choose part of it as a beautiful finishing touch to create a light or bright table setting"),

    HomeData(
        icon = R.drawable.tableware4,
        title = "STRIMMIG",
        price = "$59.99",
        seen = 99,
        liked = 38,
        introduce = "Simple modern details combined with handmade textures create many possibilities for you."),
)

