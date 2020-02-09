package com.br.teste.cubosfilme;

import com.br.teste.cubosfilme.model.Filme;
import com.br.teste.cubosfilme.rest.RetrofitCallbackKt;
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter;
import com.br.teste.cubosfilme.ui.fragment.FilmesFragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class TesteExemplo {
    @Mock
    private FilmesAdapter adapter;

    @Test
    public void teste() throws InterruptedException {
        /*FilmesFragment fragment = new FilmesFragment();

        Thread.sleep(2000);
        fragment.filmesTask(new Function1<Filme, Unit>() {
            @Override
            public Unit invoke(Filme filme) {
                return null;
            }
        });
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                RetrofitCallbackKt argument = invocation.getArgument(1);

                return null;
            }
        });

        int quantidadeFilmesDevolvido = adapter.getItemCount();

        assertThat(quantidadeFilmesDevolvido, is(1));*/


    }
}
