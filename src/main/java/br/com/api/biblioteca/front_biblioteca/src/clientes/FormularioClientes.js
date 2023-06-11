export default function FormularioClientes({ botaoCadastrar, aoDigitar, cadastrarCliente }) {
    return (
        <form>
            <div className='input-group mb-3'>
                <input type='text' placeholder='Nome' onChange={aoDigitar} name='nome' className='form-control' />
                <input type='text' placeholder='Sobrenome' onChange={aoDigitar} name='sobrenome' className='form-control' />
                <input type='text' placeholder='Telefone' onChange={aoDigitar} name='telefone' className='form-control' />
                <input type='text' placeholder='Bairro' onChange={aoDigitar} name='bairro' className='form-control' />
                <input type='text' placeholder='Rua' onChange={aoDigitar} name='rua' className='form-control' />
            </div>
            {/*Condição da visibilidade dos botões*/}
            {
                botaoCadastrar
                    ?
                    <input type='button' value='Cadastrar' onClick={cadastrarCliente} className='btn btn-primary' />
                    :
                    <div>
                        <input type='button' value='Alterar' className='btn btn-warning' />
                        <input type='button' value='Remover' className='btn btn-danger' />
                        <input type='button' value='Cancelar' className='btn btn-secondary' />
                    </div>
            }
        </form>
    );
}