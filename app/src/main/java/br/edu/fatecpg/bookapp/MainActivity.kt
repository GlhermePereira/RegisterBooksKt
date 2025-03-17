package br.edu.fatecpg.bookapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.bookapp.dao.BookDao
import br.edu.fatecpg.bookapp.model.Book


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtAutor = findViewById<EditText>(R.id.edtAutor)
        val btnCadastrar = findViewById<Button>(R.id.btnSalvar)
        val dao = BookDao.getInstance()  // Usando o Singleton para acessar a mesma instância

        btnCadastrar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val autor = edtAutor.text.toString()

            // Criar e inserir o livro no DAO
            val livro = Book(titulo, autor)
            dao.inserir(livro)

            // Passando para a próxima tela com os dados
            val intent = Intent(this, BookInfo::class.java)
            startActivity(intent)
        }
    }
}