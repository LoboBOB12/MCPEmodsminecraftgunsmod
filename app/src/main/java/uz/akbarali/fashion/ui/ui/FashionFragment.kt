package uz.akbarali.fashion.ui.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.rvadapter.AdmobNativeAdAdapter
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.FragmentBlankBinding
import uz.akbarali.fashion.ui.MainActivity
import uz.akbarali.fashion.ui.adapter.FashionAdapter
import uz.akbarali.fashion.ui.adapter.MainAdapter
import uz.akbarali.fashion.ui.modal.Download
import uz.akbarali.fashion.ui.modal.Fashion
import androidx.core.content.ContextCompat
import android.content.*
import android.os.Build
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.android.billingclient.api.*
import uz.akbarali.fashion.databinding.ActivitySubscribeBinding
import uz.akbarali.fashion.ui.service.BroadcastService
// Создаем имя файла для SharedPreferences
private val SHARED_PREFS_NAME = "my_prefs"

// Создаем ключ для параметра, который мы будем сохранять
private val PARAMETER_KEY = "my_parameter"

// Объявляем переменную SharedPreferences
private lateinit var sharedPreferences: SharedPreferences


class FashionFragment : Fragment(), FashionAdapter.MyClickListener {

    lateinit var binding: FragmentBlankBinding
    lateinit var adapter: FashionAdapter
    private lateinit var mainAdapter: MainAdapter

    private val SCROLL_DIRECTION_UP = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(layoutInflater)
        //mainAdapter = MainAdapter(requireActivity(), loadData(), this)
        adapter = FashionAdapter(loadData(), this, requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE))
        //binding.rv.adapter = mainAdapter

        binding.toolbar.title =     getString(R.string.fashion)


        val admobNativeAdAdapter: AdmobNativeAdAdapter = AdmobNativeAdAdapter.Builder
            .with(
                "ca-app-pub-2782660208341547/8061572206",  //Create a native ad id from admob console
                adapter,  //The adapter you would normally set to your recyClerView
                "medium" //Set it with "small","medium" or "custom"
            )
            .adItemIterval(2) //native ad repeating interval in the recyclerview
            .build()

        binding.rv.adapter = admobNativeAdAdapter

        return binding.root
    }

    private fun loadData(): ArrayList<Fashion> {
        val list = ArrayList<Fashion>()
        list.add(
            Fashion(
                R.drawable.media1, getString(R.string.ur), getString(R.string.minecraft_n_n_thunder_weapons_3)
            )
        )
        list.add(
            Fashion(
                R.drawable.media2,
                getString(R.string.rtet34t222),
                        getString(R.string.rtet34t2ww22)
            )
        )
        list.add(
            Fashion(
                R.drawable.media3,
                getString(R.string.w),
                getString(R.string.a1)
            )
        )
        list.add(
            Fashion(
                R.drawable.media4,
                getString(R.string.a2),
                getString(R.string.a3)
            )
        )
        list.add(
            Fashion(
                R.drawable.media5,
                getString(R.string.rt),
                        getString(R.string.minecraft_bedrock_machetes_6)
            )
        )
        list.add(
            Fashion(
                R.drawable.media6,
                getString(R.string.a4),
                getString(R.string.a5)
            )
        )
        list.add(
            Fashion(
                R.drawable.media7,
                getString(R.string.sq),
                getString(R.string.a6)
            )
        )
        list.add(
            Fashion(
                R.drawable.media8,
                getString(R.string.a6),
                getString(R.string.a8)
            )
        )
        list.add(
            Fashion(
                R.drawable.media9,
                getString(R.string.a9),
                getString(R.string.a10)
            )
        )
        list.add(
            Fashion(
                R.drawable.media10,
                getString(R.string.a11),
                getString(R.string.a12)
            )
        )
        list.add(
            Fashion(
                R.drawable.media11,
                getString(R.string.a13),
                getString(R.string.a14)
            )
        )
        list.add(
            Fashion(
                R.drawable.media12,
                getString(R.string.a15),
                getString(R.string.a16)
            )
        )
        list.add(
            Fashion(
                R.drawable.media13,
                getString(R.string.a17),
                getString(R.string.a18)
            )
        )
        list.add(
            Fashion(
                R.drawable.media14,
                    getString(R.string.a19),
                getString(R.string.a20)
            )
        )
        list.add(
            Fashion(
                R.drawable.media15,
                getString(R.string.a21),
                getString(R.string.a22)
            )
        )
        return list
    }


    override fun onClick(fashion: Fashion, position: Int) {
        when (position) {
            0 -> {
                findNavController().navigate(R.id.thunderWeaponFragment)
            }
            1 -> {
                findNavController().navigate(R.id.alotOfFirearmsFragment)
            }
            2 -> {
                findNavController().navigate(R.id.staffsFragment)
            }
            3 -> {
                findNavController().navigate(R.id.riflesFragment)
            }
            4 -> {
                findNavController().navigate(R.id.macheteFragment)
            }
            5 -> {
                findNavController().navigate(R.id.ALFArmamentFragment)
            }
            6 -> {
                findNavController().navigate(R.id.elementalSwordsFragment)
            }
            7 -> {
                findNavController().navigate(R.id.spidermanUniverseFragment)
            }
            8 -> {
                findNavController().navigate(R.id.realistic3DweaponsFragment)
            }
            9 -> {
                findNavController().navigate(R.id.luckyFragment)
            }
            10 -> {
                findNavController().navigate(R.id.levelsParkourMapFragment)
            }
            11 -> {
                findNavController().navigate(R.id.shadersFragment)
            }
            12 -> {
                findNavController().navigate(R.id.demonSlayerFragment)
            }
            13 -> {
                findNavController().navigate(R.id.furnitureFragment)
            }
            14 -> {
                findNavController().navigate(R.id.poppyPlaytimeFragment)
            }
        }
    }

    override fun download(fashion: Fashion, position: Int) {
        when (position) {
            0 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8826",
                    "https://addon-mcpe.com/engine/download.php?id=8826",
                    "thunder-weapons-rp.mcpack"
                )
            }
            1 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8796",
                    "https://addon-mcpe.com/engine/download.php?id=8796",
                    "actualgunsb.mcpack"
                )
            }


            2 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8780",
                    "https://addon-mcpe.com/engine/download.php?id=8780",
                    "magical-wands-v2-bp.mcpack"
                )
            }
            3 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8737",
                    "https://addon-mcpe.com/engine/download.php?id=8737",
                    "minecraft-rifles-addon.mcaddon"
                )

            }

            4 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8672",
                    "https://addon-mcpe.com/engine/download.php?id=8672",
                    "machetes_addon.mcaddon"
                )
            }

            5 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8582",
                    "https://addon-mcpe.com/engine/download.php?id=8582",
                    "npa-christmas.mcpack"
                )
            }



            6 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/download.php?id=8563",
                    "https://addon-mcpe.com/engine/download.php?id=8563",
                    "elementalswordsbpv4_1.mcpack"
                )
            }

            7 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8437",
                    "https://addon-mcpe.com/engine/download.php?id=8437",
                    "spiderverse-behaviorpack.mcpack"
                )
            }

            8 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8257",
                    "https://addon-mcpe.com/engine/download.php?id=8257",
                    "actualguns_3d.mcaddon"
                )
            }

            9 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=1178",
                    "https://addon-mcpe.com/engine/download.php?id=1178",
                    "luckyblocksracev2.zip"
                )
            }


            10 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=937",
                    "https://addon-mcpe.com/engine/download.php?id=937",
                    "fls3g-rbthe-grid.mcworld"
                )
            }


            11 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=1174",
                    "https://addon-mcpe.com/engine/download.php?id=1174",
                    "dynamiclightspe.mcpack"
                )
            }


            12 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=6966",
                    "https://addon-mcpe.com/engine/download.php?id=6966",
                    "akuma-no-isan-rp.mcpack"
                )
            }


            13-> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8496",
                    "https://addon-mcpe.com/engine/download.php?id=8496",
                    "furnicraft-v18_1-behavior.mcpack"
                )
            }

            14 -> {
                Download.linkFromDownload(
                    requireContext(),
                    "https://addon-mcpe.com/engine/file.php?id=8657",
                    "https://addon-mcpe.com/engine/download.php?id=8657",
                    "poppy_playtime_addon_v2_by_bendythedemon18.mcaddon"
                )
            }
        }
    }


}