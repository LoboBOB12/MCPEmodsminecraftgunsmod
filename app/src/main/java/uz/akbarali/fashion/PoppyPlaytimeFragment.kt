package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentPoppyPlaytimeBinding
import uz.akbarali.fashion.ui.modal.Download


class PoppyPlaytimeFragment : Fragment() {
    lateinit var binding: FragmentPoppyPlaytimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPoppyPlaytimeBinding.inflate(layoutInflater)
        binding.toolbar.title = getString(R.string.a21)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8657",
                "https://addon-mcpe.com/engine/download.php?id=8657",
                "poppy_playtime_addon_v2_by_bendythedemon18.mcaddon"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8657",
                "https://addon-mcpe.com/engine/download.php?id=8657",
                "poppy_playtime_addon_v2_by_bendythedemon18.mcaddon"
            )
        }
        return binding.root
    }


}