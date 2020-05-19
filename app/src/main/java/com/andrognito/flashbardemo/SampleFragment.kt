package com.andrognito.flashbardemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.andrognito.flashbar.Flashbar
import kotlinx.android.synthetic.main.fragment_sample.*

class SampleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sample, container, false)

        var flashbar: Flashbar? = null

        view.findViewById<Button>(R.id.fragmentShow).setOnClickListener {
            if (flashbar == null) {
                flashbar = Flashbar.Builder(fragment = this)
                        .gravity(Flashbar.Gravity.BOTTOM)
                        .message("This is a basic fragment flashbar")
                        .build()
            }

            flashbar?.show()
        }

        view.findViewById<Button>(R.id.fragmentDismiss).setOnClickListener {
            flashbar?.dismiss()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = SampleFragment()
    }
}
