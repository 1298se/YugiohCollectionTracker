package tang.song.edu.yugiohcollectiontracker.network

import javax.inject.Inject

class CardDataSource @Inject constructor(
    private val cardRetrofitService: CardRetrofitService
){
    suspend fun getAllCards() = cardRetrofitService.getAllCards()
}
