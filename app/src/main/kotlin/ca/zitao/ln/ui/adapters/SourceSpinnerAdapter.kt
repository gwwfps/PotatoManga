package ca.zitao.ln.ui.adapters

import android.content.Context
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ca.zitao.ln.models.Source

public class SourceSpinnerAdapter(val context: Context) : BaseAdapter() {
  override fun getCount(): Int {
    return Source.values().size
  }
  override fun getItem(i: Int): Any? {
    return Source.values()[i]
  }
  override fun getItemId(i: Int): Long {
    return i.toLong()
  }
  override fun getView(i: Int, view: View?, parent: ViewGroup): View? {
    val textView = TextView(context)
    textView.setText(Source.values()[i].name())
    return textView
  }
}