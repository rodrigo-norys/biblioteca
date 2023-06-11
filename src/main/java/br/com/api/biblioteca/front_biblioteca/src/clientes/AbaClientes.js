import { useEffect, useState } from "react";
import FormularioClientes from "./FormularioClientes";
import TabelaClientes from "./TabelaClientes";

export default function AbaClientes() {

    // Objeto Cliente.
    const cliente = {
        id_cliente: 0,
        nome: '',
        sobrenome: '',
        telefone: 0,
        bairro: '',
        rua: ''
    }

    // State responsável pela visualização dos botões de ação baseado no botão de CADASTRAR.
    const [botaoCadastrar, setBotaoCadastrar] = useState(true);
    // State responsável por aramazenar os dados dos clientes.
    const [clientes, setClientes] = useState([]);
    // State responsável por manipular o objeto cliente.
    const [objetoCliente, setObjetoCliente] = useState(cliente);

    // useEffect responsável por fazer a requisição e LISTAR os clientes.
    useEffect(() => {
        fetch("http://localhost:8080/listarClientes")
            .then(retorno => retorno.json())
            .then(retorno_convertido => setClientes(retorno_convertido))
    }, []);

    // Obtendo os dados do formulário.
    const aoDigitar = (evento) => {
        setObjetoCliente({ ...objetoCliente, [evento.target.name]: evento.target.value });
    }

    // Cadastrar Cliente.
    const cadastrarCliente = () => {
        fetch("http://localhost:8080/cadastrarClientes", {
            method: 'POST',
            body: JSON.stringify(objetoCliente),
            headers: {
                'Content-type': 'application/json',
                'Accept': 'application/json'
            }
        })
            .then(retorno => retorno.json())
            .then(retorno_convertido => {
                console.log(retorno_convertido);
            })
    }

    return (
        <div>
            <p>{JSON.stringify(objetoCliente)}</p>
            <FormularioClientes botaoCadastrar={botaoCadastrar} aoDigitar={aoDigitar} cadastrarCliente={cadastrarCliente}/>
            <TabelaClientes clientes={clientes} />
        </div>
    );
}