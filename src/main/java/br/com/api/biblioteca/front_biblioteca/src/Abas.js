export default function Abas({ children, isActive, onClick }) {
    // Se estiver ativo irá selecionar e mostrar a aba ativa.
    if (isActive) {
        return <b>{children}</b>
    }
    // Em seguida, um botão com a propriedade onClick, recebendo a função onClick() para manter a aba que for clicada ativa.
    return (
        <button onClick={() => { onClick() }}>
            {children}
        </button>
    )
}