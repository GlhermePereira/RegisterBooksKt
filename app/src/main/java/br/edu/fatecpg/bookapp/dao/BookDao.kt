package br.edu.fatecpg.bookapp.dao
import br.edu.fatecpg.bookapp.model.Book

class BookDao {
    private val livros = mutableListOf<Book>()

    // Função para inserir livro
    fun inserir(livro: Book) {
        livros.add(livro)
    }

    // Função para obter o último livro inserido
    fun getUltimo(): Book? {
        return livros.lastOrNull()
    }

    // Função para acessar a instância do DAO
    companion object {
        @Volatile
        private var INSTANCE: BookDao? = null

        fun getInstance(): BookDao {
            return INSTANCE ?: synchronized(this) {
                val instance = BookDao()
                INSTANCE = instance
                instance
            }
        }
    }
}