import { useEffect, useState } from "react";
import FormularioClientes from "./FormularioClientes";
import TabelaClientes from "./TabelaClientes";

export default function AbaClientes() {

    // State responsável pela visualização dos botões de ação baseado no botão de CADASTRAR.
    const [botaoCadastrar, setBotaoCadastrar] = useState(true);
    // State responsável por aramazenar os objetos clientes.
    const [clientes, setClientes] = useState([]);

    // useEffect responsável por fazer a requisição e LISTAR os clientes.
    useEffect(() => {
        fetch("http://localhost:8080/listarClientes")
            .then(retorno => retorno.json())
            .then(retorno_convertido => setClientes(retorno_convertido))
    }, []);
    return (
        <div>
            <FormularioClientes botaoCadastrar={botaoCadastrar} />
            <TabelaClientes clientes={clientes} />
        </div>
    );
}