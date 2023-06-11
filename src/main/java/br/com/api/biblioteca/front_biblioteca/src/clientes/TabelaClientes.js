export default function TabelaClientes({ clientes }) {
    return (
        <table className="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Telefone</th>
                    <th>Bairro</th>
                    <th>Rua</th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                {
                    clientes.map((Cliente, indiceCliente) => (
                        <tr key={indiceCliente}>
                            <td>{indiceCliente + 1}</td>
                            <td>{Cliente.nome}</td>
                            <td>{Cliente.sobrenome}</td>
                            <td>{Cliente.telefone}</td>
                            <td>{Cliente.bairro}</td>
                            <td>{Cliente.rua}</td>
                            <td><button className='btn btn-success'>Selecionar</button></td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    );
}