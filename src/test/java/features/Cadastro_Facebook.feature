
 # language: pt

  Funcionalidade: Cadastro para facebook

    Cenario: Testando o cadastro de conta

Funcionalidade: Cadastro para facebook

Cenario: Testando o cadastro de conta

  Esquema do Cenario:
    Dado o usuario estará na pagina de cadastro da conta do facebook
    Quando o mesmo irá colocar seus dados pessoais <cadastro>
    Entao o usuario irá realizar o cadastro com <titulo_obtido>

    Exemplos:

      | cadastro   | titulo_esperado                 |
      | "Nome"     | "Digite Eric"                   |
      | "Sobrenome"| "Digite Maciel"                 |
      | "Email"    | "Digite Ericmaciel173@gmail.com"|
      | "Senha"    | "Digite 5616541%$#"             |
      | "Sexo"     | "Digite Masculino ou Femenino"  |
      | "Idade"    | "Digite 21"                     |

