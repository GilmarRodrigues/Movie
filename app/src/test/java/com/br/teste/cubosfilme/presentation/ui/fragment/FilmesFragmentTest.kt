package com.br.teste.cubosfilme.presentation.ui.fragment

private const val GENERO_ACAO = 28
private const val TEMPO_MILISEGUNDOS: Long = 5000
private const val ERRO_AO_BUSCAR_DADOS_NA_API = "Erro ao buscar dados na api"

class FilmesFragmentTest {
/*    private lateinit var mFilme: Filme

    @Before
    fun setup() {
        carregaFilmes(GENERO_ACAO)
        // delay para carregar os filmes da ap
        Thread.sleep(TEMPO_MILISEGUNDOS)
    }

    @Test
    fun deve_CarregarListaDeFilme_QuandoBuscarFilmesNaApiPorGenero() {
        if (mFilme == null) {
            fail(ERRO_AO_BUSCAR_DADOS_NA_API)
        }

        val adapter = FilmesFragment().configuraAdapter(mFilme)
        val quantidadeFilmes = mFilme.results.size

        assertThat(quantidadeFilmes, `is`(adapter.itemCount))

    }

    private fun carregaFilmes(genero: Int) {
        FilmeRestTest.filmesPorGeneros(API_TOKEN, IDIOMA, genero, { filme ->
            mFilme = filme
        },{})
    }*/
}