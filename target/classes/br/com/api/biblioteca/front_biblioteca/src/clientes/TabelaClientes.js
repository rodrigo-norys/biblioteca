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
                    clientes.map((objetoCliente, indiceCliente) => (
                        <tr key={indiceCliente}>
                            <td>{indiceCliente + 1}</td>
                            <td>{objetoCliente.nome}</td>
                            <td>{objetoCliente.sobrenome}</td>
                            <td>{objetoCliente.telefone}</td>
                            <td>{objetoCliente.bairro}</td>
                            <td>{objetoCliente.rua}</td>
                            <td><button className='btn btn-success'>Selecionar</button></td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    );
}