import FormularioClientes from "./FormularioClientes";
import TabelaClientes from "./TabelaClientes";

export default function AbaClientes() {
    return (
        <div className="AbaClientes">
            <FormularioClientes />
            <TabelaClientes />
        </div>
    );
}