package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentStaffsBinding
import uz.akbarali.fashion.ui.modal.Download


class StaffsFragment : Fragment() {
    lateinit var binding: FragmentStaffsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStaffsBinding.inflate(layoutInflater)
        binding.toolbar.title =  getString(R.string.w)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8780",
                "https://addon-mcpe.com/engine/download.php?id=8780",
                "magical-wands-v2-bp.mcpack"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/download.php?id=8781",
                "https://addon-mcpe.com/engine/download.php?id=8781",
                "magical-wands-v2-rp.mcpack"
            )
        }
        return binding.root
    }


}