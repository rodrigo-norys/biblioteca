import { useState, useTransition } from 'react';
import Abas from './Abas.js';
import AbaClientes from './clientes/AbaClientes.js';
import AbaPedidos from './pedidos/AbaPedidos.js';

export default function AbaContainer() {
  const [pendente, iniciarTransicao] = useTransition();
  const [aba, setAba] = useState('abaClientes');

  {/* Função de transição das abas */ }
  function selecionarAba(proximaAba) {
    iniciarTransicao(() => {
      setAba(proximaAba);
    });
  }

  return (
    <>
      {/* Aba dos clientes */}
      <Abas
        isActive={aba === 'abaClientes'}
        onClick={() => selecionarAba('abaClientes')}
      >
        Clientes
      </Abas>
      {/* Aba dos pedidos */}
      <Abas
        isActive={aba === 'abaPedidos'}
        onClick={() => selecionarAba('abaPedidos')}
      >
        Pedidos
      </Abas>
      <hr />
      {aba === 'abaClientes' && <AbaClientes />}
      {aba === 'abaPedidos' && <AbaPedidos />}
    </>
  );
}
