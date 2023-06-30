
[ ] Cenario: AlunoGrad realizar emprestimo satisfazendo todas condições
Pré-condições: ter um aluno grad, um livro, e um exemplar no sistema
Resultado esperado: sistema imprimir o nome do usuario, o titulo do livro e uma mensagem de sucesso

[ ] Cenario: AlunoGrad realizar emprestimo quando nao existem exemplares
Pré-condições: ter um aluno grad e um livro no sistema
Resultado esperado: O emprestimo nao ser realizado, imprimir o nome do usuario, o titulo do livro e a mensagem "Não existe exemplar disponivel."

[ ] Cenario: AlunoGrad realizar emprestimo quando todos exemplares estao emprestados
Pré-condições: ter um aluno grad, um livro no sistema e todos exemplares desse livro estarem emprestados
Resultado esperado: O emprestimo nao ser realizado, imprimir o nome do usuario, o titulo do livro e a mensagem "Não existe exemplar disponivel."

[ ] Cenario: AlunoGrad realizar emprestimo quando todos exemplares estao reservados
Pré-condições: ter um aluno grad, um livro no sistema e todos exemplares desse livro estarem reservados
Resultado esperado: O emprestimo nao ser realizado, imprimir o nome do usuario, o titulo do livro e a mensagem "Não existe exemplar disponivel."

[ ] Cenario: AlunoGrad realizar emprestimo enquanto estiver "devendo" um livro
Pré-condições: ter um aluno grad, dois livros, um exemplar de cada livro e o aluno estiver com um livro emprestado atrasado.
Resultado esperado: O emprestimo nao ser realizado, imprimir o nome do usuario, o titulo do livro e a mensagem "O usuario esta devendo um livro."

[ ] Cenario: AlunoGrad realizar emprestimo enquanto possuir o maximo de emprestimos permitido
Pré-condições: ter um aluno grad, 4 livros, um exemplar de cada livro e o aluno estiver com o maximo de livros emprestados em aberto.
Resultado esperado: O emprestimo nao ser realizado, imprimir o nome do usuario, o titulo do livro e a mensagem "O usuario esta no limite de emprestimos."

[ ] Cenario: AlunoGrad realizar emprestimo quando todos os exemplares estao reservados, mas o usuario tem reserva
Pré-condições: ter um aluno grad, 1 livro, um exemplar, o exemplar estar reservado e a reserva ser do usuario.
Resultado esperado: sistema imprimir o nome do usuario, o titulo do livro, uma mensagem de sucesso e depois remover a reserva do usuario.

[ ] Cenario: AlunoGrad realizar emprestimo enquanto o usuario possuir um exemplar do livro emprestado
Pré-condições: ter um aluno grad, 1 livro, dois exemplar e usuario possuir um dos exemplares emprestados.
Resultado esperado: o emprestimo nao ser realizado, imprimir o nome do usuario, o titulo do livro e a mensagem "Usuario ja possui um exemplar do livro emprestado."
