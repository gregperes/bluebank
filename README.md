

## Requisitos técnicos
- Interface web: em WordPress;
- Backend construído em PHP;
- Utilizar OOP;
- Banco de dados relacional: MySQL;
- Instruções para deploy e execução;
- Pequeno memorando com justificativa de decisões técnicas.


## Frameworks são bem vindos!
Bootstrap e WordPress


## Instalação
- Os arquivos do projeto só funciona como um tema do WordPress
- Para visualizar as páginas conforme projetado é preciso instalá-lo
- Link de instrução da [instalação do WordPress](https://codex.wordpress.org/pt-br:Instalando_o_WordPress_-_Instru%C3%A7%C3%B5es_Detalhadas)

- Após realizar a instalação do WordPress, basta instalar este tema.
- No link a cima não fala como instalar usando o Docker. Mas, se achar mais fácil
- Nesse [link](https://hub.docker.com/_/wordpress) tem um docker-compose.yml já com MySQL

- Uma outra maneira ainda mais fácil, é usar a infraestrutura do Docker Hub para realizar testes
- Basta a acessar o [Docker Hub](https://hub.docker.com/_/wordpress) e clicar em **Try in PWD**
- Ao clicar neste botão, o WordPress será instalado instantaneamente em sugundos

## Instalação do Tema
- há várias maneiras de fazer isso. A mais fácil é pelo painel admin do WordPress

#### Pelo painel admin 
- **para acessar o painel admin***, acesse http://site/wp-admin
- forneça o login e senha cadastrado na instalação
- Em Aparência > temas
- Selecione **adicionar novo**
- Em seguida: **enviar arquivos**
- Selecione este projeto (formato .zip)
- Agora é só clicar em **ativar** logo após o Upload.

#### Se tiver no ambiente de teste do Docker Hub
- Clone o repositório https://github.com/mrgenesis/bluebank dentro da pasta home/wp-content/themes
- Em Aparência > temas > ativar o BlueBank