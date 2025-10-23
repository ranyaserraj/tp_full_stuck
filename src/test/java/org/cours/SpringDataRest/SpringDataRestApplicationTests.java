package org.cours.SpringDataRest;

import static org.assertj.core.api.Assertions.assertThat;
import org.cours.web.VoitureController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//indique que c'est une classe de test régulier qui exécute les tests à base de Spring boot
class SpringDataRestApplicationTests {
	
	@Autowired
	VoitureController voitureController;
	
	@Test
	//indique que cette méthode peut être exécutée comme un cas de test
	void contextLoads() {
		assertThat(voitureController).isNotNull();
		//on teste si l'instance du contrôleur a été créé et injectée avec succès.
	}

}
