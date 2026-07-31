
        function abrirPlayer() {
            document.getElementById('player-modal').classList.remove('hidden');
        }

        function fecharPlayer() {
            document.getElementById('player-modal').classList.add('hidden');
        }

        function iniciarWatchParty() {
            alert("Sala de Watch Party criada com sucesso! Convide os seus amigos.");
        }

        
        async function removerFavorito(idAnime) {
            if(!confirm("Deseja mesmo remover este anime dos favoritos?")) return;
            try {
                const response = await fetch(`${API_URL}/favoritos/${USUARIO_LOGADO.id}/${idAnime}`, {
                    method: 'DELETE'
                });
                if(response.ok) {
                    alert("Removido com sucesso!");
                    carregarFavoritos(); 
                } else {
                    alert("Erro ao remover. Certifique-se de que reiniciou o Spring Boot.");
                }
            } catch (e) { console.error(e); }
        }

        function abrirPagamento() {
            document.getElementById('payment-modal').classList.remove('hidden');
        }

        function fecharPagamento() {
            document.getElementById('payment-modal').classList.add('hidden');
        }

        function processarPagamento() {
            alert("Pagamento processado com sucesso! Bem-vindo ao Animax Premium!");
            fecharPagamento();
        }

        
function mudarIdioma(tipo) {
    let selectElement;
    
    
    if (tipo === 'áudio') {
        selectElement = document.getElementById('audio-lang');
    } else if (tipo === 'legenda') {
        selectElement = document.getElementById('sub-lang');
    }

    
    const idiomaSelecionado = selectElement.options[selectElement.selectedIndex].text;
    const codigoIdioma = selectElement.value;

    if (codigoIdioma === "off") {
        alert(`As ${tipo}s foram desativadas.`);
        console.log(`[Player DRM] Trilha de ${tipo} desativada.`);
        return;
    }

    
    alert(`🔄 Carregando trilha de ${tipo}: ${idiomaSelecionado}...`);
    console.log(`[Player DRM] Trilha de ${tipo} alterada para: ${codigoIdioma}`);
}