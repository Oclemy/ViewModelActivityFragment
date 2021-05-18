package info.camposha.viewmodel_activity_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MyFragment : Fragment() {
    private var mViewModel: MyViewModel? = null
    private var textView: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_fragment, container, false)
        textView = view.findViewById<View>(R.id.message) as TextView
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        ViewModelProvider(activity!!).get(MyViewModel::class.java).message!!.observe(
            viewLifecycleOwner, { message ->
                textView!!.text = message
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            })
    }

    companion object {
        @JvmStatic
        fun newInstance(): MyFragment {
            return MyFragment()
        }
    }
}