import static java.lang.IO.readln;

void main() {
    List<Pessoa> banco = new ArrayList<>();
    banco.add(new Pessoa(1, "julia", 14));
    banco.add(new Pessoa(2, "jonata", 22));
    banco.add(new Pessoa(3, "jhllya", 66));
    banco.add(new Pessoa(4, "Nicolas", 33));
    banco.add(new Pessoa(5, "Sthefany", 99));

    List<Pessoa> cache = new ArrayList<>();
    int limite = 3;            // troque para 10 depois do teste
    int quantidadeCache = 0;

    boolean rodando = true;

    while (rodando) {
        int id = Integer.parseInt(readln("\nDigite o ID (0 para sair): "));

        if (id == 0) {
            IO.println("Encerrando...");
            rodando = false;
        } else {
            boolean achouNoCache = false;

            // 1) procura no cache
            for (Pessoa p : cache) {
                if (p.getId() == id) {
                    achouNoCache = true;
                    IO.println("Pessoa encontrada no cache: " + p);
                    break;
                }
            }

            if (!achouNoCache) {
                boolean achouNoBanco = false;


                for (Pessoa p : banco) {
                    if (p.getId() == id) {
                        achouNoBanco = true;


                        if (quantidadeCache == limite) {
                            cache.remove(0);
                            quantidadeCache--;
                        }

                        cache.add(p);
                        quantidadeCache++;
                        IO.println("Pessoa buscada no banco e adicionada ao cache: " + p);
                        break;
                    }
                }

                if (!achouNoBanco) {
                    IO.println("Pessoa não encontrada.");
                }
            }
        }
    }
}