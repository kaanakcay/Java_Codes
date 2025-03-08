package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // bu configuration eklenince artik application propertiesdeki userlara bakmicak spring direkt burayi baz alacak
    //su anda database yerine memory de saklayacagimiz icin inmemory manager dedik ismine
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan);
//
//    }

    // ustteki commentledigim kodda userlari memory de tutmustuk yani direkt mock olarak backendde olusturduk ama simdi database e ekledim user ve authority (role) olarak
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){ //burada datasource spring boot tarafindan otomatik inject ediliyor.
        return new JdbcUserDetailsManager(dataSource); // burada use jdbc authentication demis oluyoruz bunu yaparken de dataSource umu kullan diyoruz. Burada database e user ve authority tablolarina bakiyor direkt olarak o yuzden o tablolari baska sekilde isimlendirmemen ve fieldlarini da olmasi gerektigi gibi kullanman gerekiyor eger default olarak kullaniyosan.
    }

    //Restricting access based on roles

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                );

        //use http basic auth
        http.httpBasic(Customizer.withDefaults());

        //disable CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
