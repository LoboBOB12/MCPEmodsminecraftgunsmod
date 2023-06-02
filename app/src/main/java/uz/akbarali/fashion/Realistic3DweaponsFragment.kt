package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentRealistic3DweaponsBinding
import uz.akbarali.fashion.ui.modal.Download


class Realistic3DweaponsFragment : Fragment() {
    lateinit var binding: FragmentRealistic3DweaponsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRealistic3DweaponsBinding.inflate(layoutInflater)
        binding.toolbar.title = getString(R.string.a9)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8257",
                "https://addon-mcpe.com/engine/download.php?id=8257",
                "actualguns_3d.mcaddon"
            )
        }
        binding.layout13.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8257",
                "https://addon-mcpe.com/engine/download.php?id=8257",
                "actualguns_3d.mcaddon"
            )
        }
        return binding.root
    }


}