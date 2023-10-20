import * as React from "react"
import {
  ChakraProvider,
  Box,
  Grid,
  extendTheme, useColorMode,
} from "@chakra-ui/react"
import styles from "./App.module.css";
import FooterComponent from "./component/footer/FooterComponent";
import NavbarComponent from "./component/navbar/NavbarComponent";
import HomeView from "./view/home/HomeView";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import PermissionView from "./view/permission/PermissionView";
import ProductView from "./view/product/ProductView";

const activeLabelStyles = {
  transform: "scale(0.85) translateY(-24px)"
};

export const theme = extendTheme({
  components: {
    // form styled default
    Form: {
      variants: {
        floating: {
          container: {
            _focusWithin: {
              label: {
                ...activeLabelStyles
              }
            },
            "input:not(:placeholder-shown) + label, .chakra-select__wrapper + label, textarea:not(:placeholder-shown) ~ label": {
              ...activeLabelStyles
            },
            label: {
              top: 0,
              left: 0,
              zIndex: 2,
              position: "absolute",
              backgroundColor: "#2D3748",
              pointerEvents: "none",
              mx: 3,
              px: 1,
              my: 2,
              transformOrigin: "left top"
            }
          }
        }
      }
    },
    // button styled default
    Button: {
      defaultProps: {
        size: 'sm',
        variant: 'outline',
        colorScheme: 'teal',
      },
    },
  }
});

export const App = () => (
  <ChakraProvider theme={theme}>
    <Box textAlign="center" fontSize="xl">
      <Grid minH="100vh" p={3}>
        <BrowserRouter>
          <NavbarComponent />
          <div id={styles.app}>
            <Routes>
              <Route path={"/"} Component={() => <HomeView />} />
              <Route path={"/product"} Component={() => <ProductView />} />
              <Route path={"/permission"} Component={() => <PermissionView />} />
            </Routes>
          </div>
          <FooterComponent />
        </BrowserRouter>
      </Grid>
    </Box>
  </ChakraProvider>
)
