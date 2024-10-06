package com.example.kisan_mitra.data

import com.example.kisan_mitra.R

object DataProvider {
    val itemsLinks =
        itemslinks(
            id = 1,
            title = "पीएमकिसान",
            url = "https://pmkisan.gov.in/",
            videoLink = "https://www.youtube.com/watch?v=tlkzyNz0c38",
            itemimageid = R.drawable.i1
        )

    val itemList = listOf(
        itemsLinks,
        itemslinks(
            id = 2,
            title = "महाभूमी",
            url = "https://bhulekh.mahabhumi.gov.in/",
            videoLink = "https://www.youtube.com/watch?v=-YyNd7Evqf0",
            itemimageid = R.drawable.i2
        ),
        itemslinks(
            id = 3,
            title = "पीएमएफबीवाई-लोगो प्रधानमंत्री फसल बीमा योजना",
            url = "https://pmfby.gov.in/",
            videoLink = "https://www.youtube.com/watch?v=fmUKBEg4vbo&t=186s",
            itemimageid = R.drawable.i3
        ),
        itemslinks(
            id = 4,
            title = "माती आरोग्य कार्ड",
            url = "https://soilhealth.dac.gov.in/home",
            videoLink = "https://www.youtube.com/watch?v=r4IMCbV4WzE",
            itemimageid = R.drawable.i4
        ),
    )
}