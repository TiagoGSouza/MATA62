- [X] Cenario: AlunoGrad realizar reserva satisfazendo todas condições
      
Pré-condições: ter um aluno grad, um livro e um exemplar no sistema

Resultado esperado: sistema imprimir o nome do usuario, o titulo do livro e uma mensagem de sucesso

- [X] Cenario: AlunoGrad realizar reserva quando nao ha exemplares

Pré-condições: ter um aluno grad e um livro no sistema

Resultado esperado: sistema imprimir o nome do usuario, o titulo do livro e a mensagem de insucesso "Nao ha exemplares disponiveis."

- [X] Cenario: AlunoGrad realizar reserva quando nao todos exemplares estao emprestados
      
Pré-condições: ter um aluno grad, um livro no sistema, um exemplar e o exemplar estar emprestado

Resultado esperado: sistema imprimir o nome do usuario, o titulo do livro e a mensagem de insucesso "Nao ha exemplares disponiveis."

FALHOU
- [ ] Cenario: AlunoGrad realizar reserva quando todos exemplares estao reservados 
      
Pré-condições: ter um aluno grad, um livro no sistema, um exemplar e o exemplar estar reservado

Resultado esperado: sistema imprimir o nome do usuario, o titulo do livro e a mensagem de insucesso "Nao ha exemplares disponiveis."

- [X] Cenario: AlunoGrad realizar reserva quando o usuario estiver no limite de suas reservas
      
Pré-condições: ter um aluno grad, 4 livros no sistema, um exemplar de cada livro e o usuario possuir 3 reservas

Resultado esperado: sistema imprimir o nome do usuario, o titulo do livro e a mensagem de insucesso "O usuario esta no limite de suas reservas."
