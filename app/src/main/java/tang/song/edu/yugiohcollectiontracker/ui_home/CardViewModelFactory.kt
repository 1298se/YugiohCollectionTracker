package tang.song.edu.yugiohcollectiontracker.ui_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tang.song.edu.yugiohcollectiontracker.network.CardRepository
import javax.inject.Inject

class CardViewModelFactory @Inject constructor (private val cardRepository: CardRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CardRepository::class.java).newInstance(cardRepository)
    }

}