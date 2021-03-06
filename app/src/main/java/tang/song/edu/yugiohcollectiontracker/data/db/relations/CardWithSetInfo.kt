package tang.song.edu.yugiohcollectiontracker.data.db.relations

import tang.song.edu.yugiohcollectiontracker.data.db.entities.Card

data class CardWithSetInfo(
    val card: Card,
    val sets: List<CardSetInfo>
)