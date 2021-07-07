package arvoreAVL;

public class Arvore {
	public NoArvore raiz;

	public Arvore() {
		this.raiz = null;
	}

	public void insere_elemento(Arvore a, String palavra, int freq, String nomeArquivo) {
		if(a.raiz.lista.primeiro == null) {
			a.raiz = new NoArvore();
			a.raiz.lista.inserePrimeiro(palavra, freq, nomeArquivo);
		} else {
			Pilha p = new Pilha(a.altura(a, a.raiz) + 1);
			NoArvore no = a.raiz;
			NoArvore q = null;
			while(no != null) {
				if(palavra.compareTo(no.lista.primeiro.palavra) > 0) {
					q = no;
					p.empilhar(no);
					no = no.direita;
				} else if(palavra.compareTo(no.lista.primeiro.palavra) < 0) {
					q = no;
					p.empilhar(no);
					no = no.esquerda;
				} else {
					break;
				}
			}
			if (no == null) {
				no = new NoArvore();
			}
			no.lista.inserePrimeiro(palavra, freq, nomeArquivo);
			if(no.lista.primeiro.palavra.compareTo(q.lista.primeiro.palavra) > 0) {
				q.direita = no;
			}else if(no.lista.primeiro.palavra.compareTo(q.lista.primeiro.palavra) < 0) {
				q.esquerda = no;
			}
			
			while(!p.vazia()) {
				a.balanceamento(a, p.topo());
				p.desempilhar();
			}
		}
	}
	
	public boolean remove_elemento(Arvore a, String palavra) {
		NoArvore p = a.raiz;
		NoArvore q = null;
		if (p == null) {
			return false;
		} else {
			while (p != null) {
				if (palavra.compareTo(p.lista.primeiro.palavra) == 0) {
					if(q.esquerda == p) {
						if(p.esquerda == null && p.direita == null) {
							q.esquerda = null;
						}else if(p.direita != null) {
							NoArvore x = menor(p.direita);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
							q.esquerda = x;
						}else if(p.esquerda != null) {
							NoArvore x = maior(p.esquerda);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
							q.esquerda = x;
						}
					}else if(q.direita == p) {
						if(p.esquerda == null && p.direita == null) {
							q.direita = null;
						}else if(p.direita != null) {
							NoArvore x = menor(p.direita);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
							q.direita = x;
						}else if(p.esquerda != null) {
							NoArvore x = maior(p.esquerda);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
							q.direita = x;
						}
					} else if(p == a.raiz) {
						if(p.esquerda == null && p.direita == null) {
							p = null;
						}else if(p.direita != null) {
							NoArvore x = menor(p.direita);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
						}else if(p.esquerda != null) {
							NoArvore x = maior(p.esquerda);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
						}
					}
					return true;
				}
				q = p;
				if(palavra.compareTo(p.lista.primeiro.palavra) > 0) {
					p = p.direita;
				} else if(palavra.compareTo(p.lista.primeiro.palavra) < 0) {
					p = p.esquerda;
				}
			}
			return false;
		}
	}
	
	public boolean existe_elemento(Arvore a,String palavra) {
		NoArvore p = a.raiz;
		if (raiz == null) {
			return false;
		} else {
			while (p != null) {
				if (palavra.compareTo(p.lista.primeiro.palavra) == 0) {
					return true;
				}
				else if (palavra.compareTo(p.lista.primeiro.palavra) < 0) {
					p = p.esquerda;
				} else {
					p = p.direita;
				}
			}
			return false;
		}
	}
	
	public void imprime_preordem(NoArvore no) {
		if (no != null) {
			no.lista.imprime();
			System.out.println("");
			imprime_preordem(no.esquerda);
			imprime_preordem(no.direita);
		}
	}
	
	public void imprime_inordem(NoArvore no) {
		if (no != null) {
			imprime_inordem(no.esquerda);
			no.lista.imprime();
			System.out.println("");
			imprime_inordem(no.direita);
		}
	}
	
	public void imprime_posordem(NoArvore no) {
		if (no != null) {
			imprime_posordem(no.esquerda);
			imprime_posordem(no.direita);
			no.lista.imprime();
			System.out.println("");
		}
	}
	
	public NoArvore maior(NoArvore no) {
        if (no == null) {
            return null;
        }
        NoArvore n = no;
        while (n.direita != null) {
            n = n.direita;
        }
        return n;
    }
    
    public NoArvore menor(NoArvore no) {
        if (no == null) {
            return null;
        }
        NoArvore n = no;
        while (n.esquerda != null) {
            n = n.esquerda;
        }
        return n;
    }
    
    public int altura (Arvore a,NoArvore no) {
    	int altura_esquerda = -1;
    	int altura_direita = -1;
    	if (no == null) { 
		      return -1; 
    	}else {
    		altura_esquerda = altura(a,no.esquerda);
		    altura_direita = altura(a,no.direita);
		    if (altura_esquerda < altura_direita) {
		    	return altura_direita + 1;
		    }
    	}
		return altura_esquerda + 1;
	}
    
    public void rot_esquerda(Arvore a, NoArvore no) {
    	NoArvore p = a.raiz;
    	NoArvore q = null;
    	
    	while (p != no) {
    		q = p;
    		if(no.lista.primeiro.palavra.compareTo(p.lista.primeiro.palavra) > 0) {
    			p = p.direita;
    		}else if(no.lista.primeiro.palavra.compareTo(p.lista.primeiro.palavra) < 0) {
    			p = p.esquerda;
    		}
    	}
    	
    	if (p == a.raiz) {
    		if(p.direita.esquerda != null) {
    			a.raiz = p.direita.esquerda;
    			p.direita.esquerda = null;
    			a.raiz.direita = p.direita;
    			p.direita = null;
    		}else {
    			a.raiz = p.direita;
    			p.direita = null;
    		}
    		a.raiz.esquerda = p;
    	}else if(q.esquerda == p) {
    		if(p.direita.esquerda != null) {
    			q.esquerda = p.direita.esquerda;
    			p.direita.esquerda = null;
    			q.esquerda.direita = p.direita;
    			p.direita = null;
    		}else {
    			q.esquerda = p.direita;
    			p.direita = null;
    		}
    		q.esquerda.esquerda = p;
    	}else if(q.direita == p) {
    		if(p.direita.esquerda != null) {
    			q.direita = p.direita.esquerda;
    			p.direita.esquerda = null;
    			q.direita.direita = p.direita;
    			p.direita = null;
    		}else {
    			q.direita = p.direita;
    			p.direita = null;
    		}
    		q.direita.esquerda = p;
    	}
    }
    
    public void rot_direita(Arvore a, NoArvore no) {
    	NoArvore p = a.raiz;
    	NoArvore q = null;
    	
    	while (p != no) {
    		q = p;
    		if(no.lista.primeiro.palavra.compareTo(p.lista.primeiro.palavra) > 0) {
    			p = p.direita;
    		}else if(no.lista.primeiro.palavra.compareTo(p.lista.primeiro.palavra) < 0) {
    			p = p.esquerda;
    		}
    	}
    	
    	if (p == a.raiz) {
    		if(p.esquerda.direita != null) {
    			a.raiz = p.esquerda.direita;
    			p.esquerda.direita = null;
    			a.raiz.esquerda = p.esquerda;
    			p.esquerda = null;
    		}else {
    			a.raiz = p.esquerda;
    			p.esquerda = null;
    		}
    		a.raiz.direita = p;
    	}else if(q.esquerda == p) {
    		if(p.esquerda.direita != null) {
    			q.esquerda = p.esquerda.direita;
    			p.esquerda.direita = null;
    			q.esquerda.esquerda = p.esquerda;
    			p.esquerda = null;
    		}else {
    			q.esquerda = p.esquerda;
    			p.esquerda = null;
    		}
    		q.esquerda.direita = p;
    	}else if(q.direita == p) {
    		if(p.esquerda.direita != null) {
    			q.direita = p.esquerda.direita;
    			p.esquerda.direita = null;
    			q.direita.esquerda = p.esquerda;
    			p.esquerda = null;
    		}else {
    			q.direita = p.esquerda;
    			p.esquerda = null;
    		}
    		q.direita.direita = p;
    	}
    }
    
    public void balanceamento(Arvore a, NoArvore no) {
    	if((a.altura(a, no.esquerda) - a.altura(a, no.direita)) < -1) {
    		a.rot_esquerda(a, no);
    	}else if((a.altura(a, no.esquerda) - a.altura(a, no.direita)) > 1) {
    		a.rot_direita(a, no);
    	}
    }
    
}