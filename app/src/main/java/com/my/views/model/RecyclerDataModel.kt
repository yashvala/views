package com.my.views.model

import com.my.views.R


data class RecyclerDataModel(
    val image: Int,
    val description: String,
)

object SeriesList {

    fun getModel(): List<RecyclerDataModel> {


        val itemModel1 = RecyclerDataModel(
            R.drawable.ic_launcher_background,
            "Lord Of The Rings",
        )

        val itemModel2 = RecyclerDataModel(
            R.drawable.ic_launcher_foreground,
            "Harry Potter",
        )


        val itemModel3 = RecyclerDataModel(
            R.drawable.ic_launcher_background,
            "Interstellar",
        )


        val itemModel4 = RecyclerDataModel(
            R.drawable.ic_launcher_foreground,
            "Squid Game",
        )


        val itemModel5 = RecyclerDataModel(
            R.drawable.ic_launcher_background,
            "How I Met Your Mother",
        )


        val itemModel6 = RecyclerDataModel(
            R.drawable.ic_launcher_foreground,
            "Vikings",
        )

        val itemModel7 = RecyclerDataModel(
            R.drawable.ic_launcher_background,
            "The Walking Dead",
        )

        val itemModel8 = RecyclerDataModel(
            R.drawable.ic_launcher_foreground,
            "Spartacus",
        )
        val itemModel9 = RecyclerDataModel(
            R.drawable.ic_launcher_background,
            "Rick and Morty",
        )
        val itemModel10 = RecyclerDataModel(
            R.drawable.ic_launcher_foreground,
            "Hababam Sınıfı",
        )


        val itemList: ArrayList<RecyclerDataModel> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)
        itemList.add(itemModel4)
        itemList.add(itemModel5)
        itemList.add(itemModel6)
        itemList.add(itemModel7)
        itemList.add(itemModel8)
        itemList.add(itemModel9)
        itemList.add(itemModel10)

        return itemList
    }

}

