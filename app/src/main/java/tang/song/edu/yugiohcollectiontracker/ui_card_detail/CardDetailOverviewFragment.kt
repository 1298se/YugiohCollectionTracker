package tang.song.edu.yugiohcollectiontracker.ui_card_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tang.song.edu.yugiohcollectiontracker.data.db.entities.Card
import tang.song.edu.yugiohcollectiontracker.data.models.CardType
import tang.song.edu.yugiohcollectiontracker.databinding.CardDetailTypeMonsterBinding
import tang.song.edu.yugiohcollectiontracker.databinding.CardDetailTypeSpellTrapBinding
import tang.song.edu.yugiohcollectiontracker.databinding.FragmentCardDetailOverviewBinding

private const val ARG_CARD = "ARG_CARD"

class CardDetailOverviewFragment : Fragment() {
    private var _binding: FragmentCardDetailOverviewBinding? = null
    private val binding
        get() = _binding!!

    private var mCard: Card? = null

    companion object {
        fun newInstance(card: Card?) =
            CardDetailOverviewFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_CARD, card)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mCard = it.getParcelable(ARG_CARD)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardDetailOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateDescriptionView(mCard)
    }

    private fun generateDescriptionView(card: Card?) {
        card?.let {
            val descriptionView: View = when (card.type) {
                CardType.SPELL_CARD, CardType.TRAP_CARD -> {
                    val spellBinding = CardDetailTypeSpellTrapBinding.inflate(LayoutInflater.from(context), binding.cardDetailOverviewContainer, false).apply {
                        cardNameTextView.text = card.name
                        cardTypeTextView.text = card.type.value
                        cardRaceTextView.text = card.race
                        cardDescriptionTextView.text = card.desc
                    }

                    spellBinding.root
                }
                CardType.UNKNOWN -> View(context)
                else -> {
                    val monsterBinding = CardDetailTypeMonsterBinding.inflate(LayoutInflater.from(context), binding.cardDetailOverviewContainer, false).apply {
                        cardNameTextView.text = card.name
                        cardTypeTextView.text = card.type.value
                        cardRaceTextView.text = card.race
                        cardAttributeTextView.text = card.attribute
                        cardAtkDefTextView.text = card.atk.toString()
                        cardDescriptionTextView.text = card.desc
                    }

                    monsterBinding.root
                }
            }

            binding.cardDetailOverviewContainer.addView(descriptionView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
