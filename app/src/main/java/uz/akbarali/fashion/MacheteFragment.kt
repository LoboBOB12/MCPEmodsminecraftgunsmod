package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentMacheteBinding
import uz.akbarali.fashion.ui.modal.Download


class MacheteFragment : Fragment() {
    lateinit var binding: FragmentMacheteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMacheteBinding.inflate(layoutInflater)
        binding.toolbar.title =  getString(R.string.rt)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8672",
                "https://addon-mcpe.com/engine/download.php?id=8672",
                "machetes_addon.mcaddon"
            )
        }
        binding.layout13.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8672",
                "https://addon-mcpe.com/engine/download.php?id=8672",
                "machetes_addon.mcaddon"
            )
        }

        return binding.root
    }

}