package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentRiflesBinding
import uz.akbarali.fashion.ui.modal.Download


class RiflesFragment : Fragment() {
    lateinit var binding: FragmentRiflesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRiflesBinding.inflate(layoutInflater)
        binding.toolbar.title = "Винтовки"
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8737",
                "https://addon-mcpe.com/engine/download.php?id=8737",
                "minecraft-rifles-addon.mcaddon"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8737",
                "https://addon-mcpe.com/engine/download.php?id=8737",
                "minecraft-rifles-addon.mcaddon"
            )
        }
        return binding.root
    }


}