{
Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
septiembre de 2025. De cada película se conoce: código de película, código de género (1:
acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y
puntaje promedio otorgado por las críticas.

Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:

a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.

b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..

c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.

d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).
}

program pelis;

const
	generos=8;
	puntajeMin=0;
	puntajeMax=10;
	fin=-1;
type
	rangoGeneros= 1..generos;
	rangoPuntaje= puntajeMin..puntajeMax;
	
	pelicula= record
		codPeli:integer;
		codGenero:rangoGeneros;
		puntajePromedio:rangoPuntaje;
	end;
	
	lista= ^nodo;
	
	nodo= record
		elem: pelicula;
		sig: lista;
	end;
	
	vecMayorPuntaje= array[rangoGeneros] of pelicula;
	
procedure leerPeli(var p:pelicula);
begin
	readln(p.codPeli);
	if (p.codPeli <> fin) then begin
		readln(p.codGenero);
		readln(p.puntajePromedio);
	end;
end;

procedure agregarAtras(var l:lista; var ult:lista; elem:pelicula);
var nue:lista;
begin
	new(nue);
	nue^.elem:= elem;
	nue^.sig:= nil;
	if (l = nil) then
		l:= nue
	else
		ult^.sig:= nue;
	ult:=nue;
end;

procedure cargarLista(var l:lista; var ult:lista);
var  p:pelicula;
begin
	leerPeli(p);
	while (p.codPeli <> fin)do begin
		agregarAtras(l,ult,p);
		leerPeli(p);
	end;
end;

procedure inicializarVec(var v:vecMayorPuntaje);
var i:integer;
begin
	for i:=1 to generos do v[i].puntajePromedio:=-1;
end;

procedure cargarVecGenero(var v:vecMayorPuntaje; l:lista);
begin
	inicializarVec(v);
	while(l <> nil) do begin
		if (l^.elem.puntajePromedio > v[l^.elem.codGenero].puntajePromedio) then begin
			v[l^.elem.codGenero].codPeli:= l^.elem.codPeli;
			v[l^.elem.codGenero].puntajePromedio:= l^.elem.puntajePromedio;
		end;
		l:= l^.sig;
	end;
end;

procedure ordenarVec(var v:vecMayorPuntaje);
var
	pos, i, j: integer;
	aux: pelicula;
begin
	for i:=1 to (generos-1) do begin
		pos:= i;
		for j:=i+1 to generos do begin
			if (v[j].puntajePromedio < v[pos].puntajePromedio) then pos:= j;
		end;
		aux:= v[pos];
		v[pos]:= v[i];
		v[i]:= aux;
	end;
end;

procedure imprimirResultado(v: vecMayorPuntaje);
begin
	writeln('Mayor puntaje (codPeli): ', v[generos].codPeli);
	writeln('Mayor puntaje (valor): ', v[generos].puntajePromedio);
	writeln('------------------------------------');
	writeln('Menor puntaje (codPeli): ', v[1].codPeli);
	writeln('Menor puntaje (valor): ', v[1].puntajePromedio);
end;

var
	l,ult: lista;
	v:vecMayorPuntaje;
begin
	l:= nil;
	ult:= nil;
	
	cargarLista(l,ult);
	cargarVecGenero(v,l);
	ordenarVec(v);
	imprimirResultado(v);
end.
