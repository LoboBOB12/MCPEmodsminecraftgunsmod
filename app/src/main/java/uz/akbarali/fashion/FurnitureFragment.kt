package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentFurnitureBinding
import uz.akbarali.fashion.ui.modal.Download


class FurnitureFragment : Fragment() {
    lateinit var binding: FragmentFurnitureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFurnitureBinding.inflate(layoutInflater)
        binding.toolbar.title =     getString(R.string.a19)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8496",
                "https://addon-mcpe.com/engine/download.php?id=8496",
                "furnicraft-v18_1-behavior.mcpack"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8497",
                "https://addon-mcpe.com/engine/download.php?id=8497",
                "furnicraft-v18_1-resource.mcpack"
            )
        }
        binding.button3.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8498",
                "https://addon-mcpe.com/engine/download.php?id=8498",
                "furnicraft-v12_5-behaviors.mcpack"
            )
        }
        binding.button4.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8498",
                "https://addon-mcpe.com/engine/download.php?id=8499",
                "furnicraft-v12_5-resource.mcpack"
            )
        }
        return binding.root
    }


}