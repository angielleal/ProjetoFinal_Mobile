# Faz Agora - Aplicativo de Organização de Tarefas

### Licença
MIT License

---

O *Faz Agora* é um aplicativo intuitivo e eficiente para gerenciar suas tarefas diárias. Desenvolvido com foco em praticidade, o aplicativo combina uma interface intuitiva com funcionalidades avançadas para garantir uma experiência fluida e segura para seus usuários.

---

### Funcionalidades Principais
1. *Adicionar Tarefas*: Crie novas tarefas de maneira rápida e organizada.  
2. *Marcar Concluídas*: Acompanhe seu progresso e celebre suas conquistas diárias.  
3. *Editar e Excluir Tarefas*: Altere ou remova tarefas existentes sem complicações.  
4. *Persistência de Dados*: Todas as tarefas são armazenadas localmente, garantindo acesso rápido e seguro.  
5. *Perfil do Usuário*: Visualize o número de tarefas concluídas, gerando motivação para manter a produtividade.  

---

### Benefícios para o Usuário
- *Organização Pessoal*: Permite criar e gerenciar tarefas de maneira eficiente.  
- *Produtividade Ampliada*: Foco nas prioridades com notificações para tarefas importantes (a ser implementado).  
- *Experiência Gamificada*: O sistema pode incluir recompensas para usuários que completam tarefas diariamente.  
- *Privacidade Garantida*: Informações armazenadas localmente ou protegidas na nuvem via Firebase.  

---

### Tecnologias Utilizadas
- *Kotlin*: Linguagem de programação oficial para desenvolvimento Android, com suporte moderno para segurança e desempenho.  
- *Room*: Biblioteca de persistência para simplificar o uso de SQLite e garantir consistência nos dados.  
- *Firebase*: Utilizado para autenticação, sincronização de dados e notificações em tempo real.
- *Corrotinas*: Gerenciamento eficiente de tarefas assíncronas para melhor desempenho e fluidez do aplicativo.  
- *Material Design*: Diretrizes modernas para criar interfaces amigáveis e consistentes.  
- *Jetpack Compose (opcional)*: Possibilidade de migrar ou incluir componentes baseados em UI declarativa no futuro.  

---

### Requisitos Técnicos
1. *Sistema Operacional*: Android 8.0 (Oreo) ou superior.  
2. *Espaço de Armazenamento*: Aproximadamente 50 MB para instalação e uso inicial.  
3. *Memória RAM*: Recomendado 2 GB ou mais para funcionamento fluido.  
4. *Configuração do Firebase*: O aplicativo requer uma conta no Firebase configurada com:
   - *Authentication* para login e cadastro de usuários.
   - *Firestore Database* para armazenamento na nuvem.
   - *Firebase Cloud Messaging (opcional)* para envio de notificações.
     
---

### Capturas de Tela
1. *Tela Principal*: Exibe todas as tarefas organizadas, permitindo edição ou exclusão com um toque.  
2. *Login*: Valida credenciais do usuário para acesso seguro e personalizado.  
3. *Adicionar Tarefa*: Interface simplificada para criação de tarefas com prioridade opcional.  
4. *Perfil*: Mostra tarefas concluídas, progresso semanal e sugestões para melhorar a produtividade.  

---

### Boas Práticas e Segurança
- *Armazenamento Local Seguro*: Dados são criptografados no banco SQLite para evitar acessos não autorizados.
- *Segurança na Nuvem*: Dados protegidos com as regras de segurança do Firebase.  
- *Testes Automatizados*: Testes unitários e instrumentados garantem a estabilidade do aplicativo.  
- *Interface Responsiva*: Otimizada para diferentes tamanhos de tela e resoluções.  

---

### Cenários de Uso
- *Estudantes*: Planejar e acompanhar tarefas de estudo e prazos de entrega.  
- *Profissionais*: Gerenciar reuniões, projetos e compromissos diários.  
- *Uso Pessoal*: Organizar tarefas domésticas, listas de compras ou planos de lazer.  

---

### Link do Protótipo no Figma
Acesse o design do aplicativo no Figma: [Faz Agora - Design](https://www.figma.com/design/Wx7hZH47puINiKQ9rugpzL/Untitled?node-id=0-1&t=7Y0Ic9xcXDNuoIbJ-1)

---

### Planejamento Futuro
- *Notificações Push com Firebase*: Envio de lembretes automáticos para tarefas prioritárias.  
- *Tema Personalizável*: Opções de tema claro e escuro para maior conforto visual.  
- *Sincronização Total com Firebase*: Inclusão de backups automáticos e sincronização entre dispositivos.  

---

### Autores
- *Angiel Leal*: [GitHub](https://github.com/angielleal)  
- *João Vitor Rocha*: [GitHub](https://github.com/JoaoVitorRodriguesRocha)
- *Lucas Daufenbach*: [GitHub](https://github.com/lucasdaufenbach)  
- *Marcos Jeronimo*: [GitHub](https://github.com/marcoshjf)  
- *Mateus Zanin*: [GitHub](https://github.com/Zaanin)  

---

### Referências
- Documentação oficial do [Kotlin](https://kotlinlang.org/).  
- Diretrizes do [Material Design](https://material.io/design).  
- Introdução ao [Room Database](https://developer.android.com/training/data-storage/room).  
- Boas práticas para [Corrotinas no Android](https://developer.android.com/kotlin/coroutines).  
- Documentação do [Firebase](https://firebase.google.com/).

---
