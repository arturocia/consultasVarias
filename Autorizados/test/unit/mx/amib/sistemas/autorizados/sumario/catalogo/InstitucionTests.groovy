package mx.amib.sistemas.autorizados.sumario.catalogo

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

import grails.test.mixin.*
import org.junit.*

// http://stackoverflow.com/questions/3720656/groovy-grails-unit-testing-createcriteria-get

@TestFor(Institucion)
class InstitucionTests {

	void testInstitucion() {

		mockDomain(Institucion, [
			new Institucion(nbInstitucion: 'Foo',stVigente:true),
			new Institucion(nbInstitucion: 'AA',stVigente:true),
			new Institucion(nbInstitucion: 'Get lucky',stVigente:true),
			new Institucion(nbInstitucion: 'Proo',stVigente:true)
		])


		def actuals = Institucion.createCriteria().list(sort: 'nbInstitucion', order: 'asc') { like('nbInstitucion', '%oo') }

		assertEquals 2, actuals.size()
	}
}