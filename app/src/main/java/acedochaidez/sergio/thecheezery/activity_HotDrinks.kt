package acedochaidez.sergio.thecheezery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.content.Context

class activity_HotDrinks : AppCompatActivity() {
    var HotDrinks = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_drinks)

        agregarProductos()

        var listView: ListView = findViewById(R.id.litview) as ListView
        var adaptador: activity_HotDrinks.AdaptadorProductos = AdaptadorProductos(this, HotDrinks)
        listView.adapter = adaptador
    }

    private fun agregarProductos() {

        HotDrinks.add(
            Product(
                "Latte",
                R.drawable.latte,
                "Coffee drink made with espresso and steamed milk",
                6.0
            )
        )
        HotDrinks.add(
            Product(
                "Hot chocolate",
                R.drawable.hotchocolate,
                "Heated drink consisting of shaved chocolate, topped with marshmallows.",
                5.0
            )
        )
        HotDrinks.add(
            Product(
                "Espresso",
                R.drawable.espresso,
                "Full-flavored, concentrated form of coffee.",
                4.0
            )
        )
        HotDrinks.add(
            Product(
                "Chai Latte",
                R.drawable.chailatte,
                "Spiced tea concentrate with milk",
                6.0
            )
        )
        HotDrinks.add(
            Product(
                "Capuccino",
                R.drawable.capuccino,
                "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.",
                7.0
            )
        )
        HotDrinks.add(
            Product(
                "American coffee",
                R.drawable.americano,
                "Espresso with hot water",
                2.0
            )
        )

    }

    private class AdaptadorProductos : BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, producto: ArrayList<Product>) {
            this.productos = producto
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}