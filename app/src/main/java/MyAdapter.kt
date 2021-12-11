import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.plant.fProfile

internal class MyAdapter(
    var context: Context?,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                fProfile()
            }
            1 -> {
                fProfile()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}