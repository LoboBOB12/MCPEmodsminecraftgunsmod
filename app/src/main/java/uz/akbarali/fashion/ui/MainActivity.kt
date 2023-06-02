package uz.akbarali.fashion.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.ActivityMainBinding
import uz.akbarali.fashion.ui.adapter.FashionAdapter
import uz.akbarali.fashion.ui.ui.FashionFragment
import uz.akbarali.fashion.ui.ui.InstructionFragment
import uz.akbarali.fashion.ui.ui.SettingsFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fashionAdapter: FashionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.selectedItemId = R.id.item1
        val navController = findNavController(R.id.nav_host_fragment)
        setupNav()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item1 -> {
                    navController.popBackStack()
                    navController.navigate(R.id.blankFragment)
                }
                R.id.item2 -> {
                    navController.popBackStack()
                    navController.navigate(R.id.instructionFragment)
                }
                R.id.item3 -> {
                    navController.popBackStack()
                    navController.navigate(R.id.settingsFragment)
                }

            }
            true

        }
    }

    private fun setupNav() {
        val navController = findNavController(R.id.nav_host_fragment)
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.thunderWeaponFragment, R.id.ALFArmamentFragment, R.id.alotOfFirearmsFragment, R.id.demonSlayerFragment, R.id.elementalSwordsFragment, R.id.furnitureFragment, R.id.levelsParkourMapFragment,
                R.id.luckyFragment, R.id.macheteFragment, R.id.poppyPlaytimeFragment,
                R.id.realistic3DweaponsFragment, R.id.riflesFragment, R.id.shadersFragment,
                R.id.spidermanUniverseFragment, R.id.staffsFragment, R.id.MCWorldFragment, R.id.RARFragment -> {
                    hideBottomNav()
                }

                else -> showBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNavigation.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        binding.bottomNavigation.visibility = View.GONE

    }

}