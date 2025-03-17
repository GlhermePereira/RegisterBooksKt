package br.edu.fatecpg.bookapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import br.edu.fatecpg.bookapp.dao.BookDao

class BookInfo : AppCompatActivity(R.layout.activity_book_info) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = BookDao.getInstance()  // Usando o Singleton para acessar a mesma instância
        val livro = dao.getUltimo()  // Obtendo o último livro inserido

        val txtTitulo = findViewById<TextView>(R.id.txtTitulo)
        val txtAutor = findViewById<TextView>(R.id.txtAutor)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fabVoltar)

        // Verifique se o livro foi encontrado e, se sim, exiba os dados
        if (livro != null) {
            // Se o livro não for nulo, atualize os campos
            txtTitulo.text = "Título: ${livro.titulo}"
            txtAutor.text = "Autor: ${livro.autor}"
        } else {
            // Caso não haja livro, exiba uma mensagem
            txtTitulo.text = "Nenhum livro encontrado"
            txtAutor.text = ""
        }

        fabVoltar.setOnClickListener {
            finish()  // Volta para a tela anterior
        }
    }
}