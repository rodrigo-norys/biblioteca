export default function FormularioClientes({ botaoCadastrar }) {
    return (
        <form>
            <div class='input-group mb-3'>
                <input type='text' placeholder='Nome' className='form-control' />
                <input type='text' placeholder='Sobrenome' className='form-control' />
                <input type='text' placeholder='Telefone' className='form-control' />
                <input type='text' placeholder='Bairro' className='form-control' />
                <input type='text' placeholder='Rua' className='form-control' />
            </div>
            {/*Condição da visibilidade dos botões*/}
            {
                botaoCadastrar
                    ?
                    <input type='button' value='Cadastrar' className='btn btn-primary' />
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