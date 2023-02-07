import Vue from "vue";
import VueRouter from "vue-router";
import CadastroPessoa from "../views/CadastroPessoa.vue";
import ListaDoacao from "../views/ListaDoacao.vue";
import CadastroDoacao from "../views/CadastroDoacao.vue";
import CadastroBairro from "../views/CadastroBairro.vue";
import RepassarDoacao from "../views/RepassarDoacao.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/cadastrarPessoa",
    name: "Cadastrar Pessoa",
    component: CadastroPessoa,
  },
  {
    path: "/listaDoacao",
    name: "Doações",
    component: ListaDoacao,
  },
  {
    path: "/cadastrarDoacao",
    name: "Cadastrar Doação",
    component: CadastroDoacao,
  },
  {
    path: "/cadastrarBairro",
    name: "Cadastrar Bairro",
    component: CadastroBairro,
  },
  {
    path: "/repassarDoacao",
    name: "Repassar Doacao",
    component: RepassarDoacao,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
