package hofy.ropeup.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import hofy.ropeup.presentation.databinding.ActivityMainBinding
import hofy.ropeup.presentation.ui.BaseFragment
import hofy.ropeup.presentation.ui.custom.LockingAppBarLayoutBehavior

class MainActivity : AppCompatActivity(), BaseFragment.IMainImageInteractionListener,
    NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navView: BottomNavigationView = binding.navView

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_profile,
                R.id.navigation_home,
                R.id.navigation_diary,
                R.id.navigation_rope_up,
                R.id.navigation_routes
            )
        )
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(this)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun onMainImageChange(res: Int) {
        binding.appBarLayout.setExpanded(true, true)
        binding.toolbarImage = res
    }

    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener(this)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        binding.collapsingToolbarLayout.title = destination.label
        when (destination.id) {
            R.id.navigation_route_creation -> {
                ((binding.appBarLayout.layoutParams as CoordinatorLayout.LayoutParams).behavior as LockingAppBarLayoutBehavior).shouldScroll =
                    false
            }
            else -> {
                binding.appBarLayout.setExpanded(false)
                ((binding.appBarLayout.layoutParams as CoordinatorLayout.LayoutParams).behavior as LockingAppBarLayoutBehavior).shouldScroll =
                    false
            }
        }
    }
}