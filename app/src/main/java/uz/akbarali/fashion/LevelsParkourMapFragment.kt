package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.akbarali.fashion.databinding.FragmentLevelsParkourMapBinding
import uz.akbarali.fashion.ui.modal.Download


class LevelsParkourMapFragment : Fragment() {
    lateinit var binding: FragmentLevelsParkourMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelsParkourMapBinding.inflate(layoutInflater)
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=937",
                "https://addon-mcpe.com/engine/download.php?id=937",
                "fls3g-rbthe-grid.mcworld"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=938",
                "https://addon-mcpe.com/engine/download.php?id=938",
                "fls3g-rbthe-grid.zip"
            )
        }
        binding.button3.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=937",
                "https://addon-mcpe.com/engine/download.php?id=937",
                "fls3g-rbthe-grid.mcworld"
            )
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=938",
                "https://addon-mcpe.com/engine/download.php?id=938",
                "fls3g-rbthe-grid.zip"
            )
        }
        return binding.root
    }
}